package com.exam.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.exam.model.Employee;
import com.exam.model.JwtRequest;
import com.exam.model.JwtResponse;
import com.exam.repository.EmployeeRepository;
import com.exam.serviceimpl.EmployeeService;
import com.exam.serviceimpl.UserService;
import com.exam.util.JWTUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



@RestController
public class HomeController {
	
	
	
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	String token;
	
	@GetMapping("/")
	public String text()
	{
		return "hai";
	}
	
	
	  @Autowired
	    private  EmployeeService employeeService;


	    @Autowired
	    private EmployeeRepository repository;

	    @PostMapping("/save")
	    public Employee saveEmployee(@RequestBody Employee employee )
	    {
	       return repository.save(employee);


	    }
	     @GetMapping("/search")
	     public List<Employee> searchEmployees(@RequestParam("name") String name) {
	            return this.employeeService.searchEmployees(name);
	     }
	    @GetMapping("/startwith")
	    public List<Employee> startWithEmployees(@RequestParam("name") String name) {
	        return repository.findByNameEndsWithIgnoreCaseNative(name);
	    }
	    @GetMapping("/endswith")
	    public List<Employee> endWithEmployees(@RequestParam("name") String name) {
	        return repository.findByNameEndsWithIgnoreCaseNative(name);
	    }

	        @GetMapping("/filter")
	        public List<Employee> filterEmployeesBySalaryRange(@RequestParam("minSalary") Double minSalary, @RequestParam("maxSalary") Double maxSalary) {
	            return this.employeeService.filterEmployeesBySalaryRange(minSalary, maxSalary);
	        }
	        
	        
	        @GetMapping("/get")
	    	public Object  getData(@RequestParam("id") String id) throws JsonProcessingException {
	    		String json = WebClient.create("https://jsonplaceholder.typicode.com/users").method(HttpMethod.GET).header(MediaType.APPLICATION_JSON_VALUE).retrieve().bodyToMono(String.class).block();
	    		Gson gson = new Gson();
	    		System.out.println(id);

	    		JsonObject jsonObject2 = null;

	    		JsonParser parser = new JsonParser();
	    		JsonArray jsonArray = parser.parse(json).getAsJsonArray();
	    		for(JsonElement obj : jsonArray){
	    			JsonObject id1 = obj.getAsJsonObject();
	    			String id2= id1.get("id").toString();
	    			if(id2.equalsIgnoreCase(id)){
	    				jsonObject2= id1;
	    			}
	    		}


	    		//System.out.println(jsonObject);

	    		/*JsonObject userObject = gson.fromJson(jsonObject, JsonObject.class);
	    		LinkedHashMap<Integer, JsonObject> userMap = new LinkedHashMap<>();
	    		userMap.put(userObject.get(""+id).getAsInt(), userObject);
	    		System.out.println(userMap.toString());*/
	    		return  jsonObject2.toString();
	    	}
	        
	        @GetMapping("/accurence")
	        public String accurencseprogram()
	        {
	        	
	        	String input="deloitte";
	    		char chartoReplace='t';;
	    		
	    		int cnt=1;
	    		for(int i=0;i<input.length();i++){
	    		char ch=input.charAt(i);
	    		if(ch==chartoReplace){
	    		input=input.replaceFirst(String.valueOf(chartoReplace),String.valueOf(cnt));
	    		cnt++;
	    		}
	    		}
	    		System.out.println(input);
	    		return "success";
	        	
	        }
	        @GetMapping("/distinctcount")
	        public String distinctCount()
	        {
	        	
	        	List<String> list = Arrays.asList("a", "b", "c", "a", "c", "o", "b", "a");

	    		Map<String, Long> map = list.stream()
	    		    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	    		Map<String, Long> duplicates = map.entrySet().stream()
	    		    .filter(entry -> entry.getValue() > 1)
	    		    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

	    		System.out.println(duplicates);
	        	return "success";
	        }
	    	@GetMapping("/authenticate")
	    	public ResponseEntity<JwtResponse>  authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
	    		try {
	    			authenticationManager
	    			.authenticate(new UsernamePasswordAuthenticationToken
	    					(jwtRequest.getUsername(), jwtRequest.getPassword()));
	    		
	    		}
	    	catch (BadCredentialsException e) {
	    		throw new Exception("INVALID_CREDENTIALS",e);
	    	}
	    	final UserDetails	userDetails
	    	=userService.loadUserByUsername(jwtRequest.getUsername());
	        token=jwtUtility.generateToken(userDetails);
	        String refreshToken=jwtUtility.generaterefreshToken(userDetails.getUsername());
	    	return ResponseEntity.ok().body(new JwtResponse(token,refreshToken));
	    	}
	    	@GetMapping("/refreshToken")
	    	public String getToken(String refreshToken){
	    		String username=jwtUtility.getUsernameFromToken(refreshToken);
	    		final UserDetails	userDetails
	    				=userService.loadUserByUsername(username);
	    		 return  token=jwtUtility.generateToken(userDetails);
	    	}
}
