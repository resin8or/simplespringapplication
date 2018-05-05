@RestController
class HelloWorld{

	@RequestMapping("/")
	def hi(){
		return "hello"
	}
}