package academy.digitallab.demo01;

public class Greeting {
	
	private Long id;
	
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Greeting() {
	}

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", message=" + message + "]";
	}

	public Greeting(Long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	
	

}
