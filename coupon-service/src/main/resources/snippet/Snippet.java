package snippet;

public class Snippet {
	public static void main(String[] args) {
		eureka.client.service-url.defaultZone=http://${EUREKA_HOST:localhost}:${EUREKA_PORT:8761}/eureka/
	}
}

