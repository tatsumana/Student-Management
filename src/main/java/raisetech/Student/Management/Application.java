package raisetech.Student.Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@RestController
public class Application {

	private Map<String, String> studentMap = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// 学生情報の取得
	@GetMapping("/studentInfo")
	public Map<String, String> getStudentInfo() {
		return studentMap;
	}

	// 学生情報の追加・更新
	@PostMapping("/studentInfo")
	public String setStudentInfo(@RequestParam String name, @RequestParam String age) {
		studentMap.put(name, age);
		return "登録・更新しました: " + name + " " + age + "歳";
	}
}
