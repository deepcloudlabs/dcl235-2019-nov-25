import com.example.ccc.service.RandomNumberService;
import com.example.ccc.service.business.SimpleRandomNumberGenerator;

module com.example.c {
	exports com.example.ccc.service;
	provides RandomNumberService with SimpleRandomNumberGenerator;
}