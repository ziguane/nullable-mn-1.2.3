package example.micronaut;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.views.View;

@Controller("/")
public class NullableController {
	private static final Logger LOG = LoggerFactory.getLogger(NullableController.class);

	
	@View("form")
    @Get("/")
    public HttpResponse<?> index() {
        return HttpResponse.ok();
    }
	
	
	// success
	@Post(uri = "/nullable/string", consumes = MediaType.MULTIPART_FORM_DATA)
	public HttpResponse<?> stringVersion(@Body @Nullable String firstname) {
		LOG.info("Success Firstname = [" + firstname + "]");
		return HttpResponse.ok(CollectionUtils.mapOf("Success Firstname",  firstname));
	}

	// failure
	@Post(uri = "/nullable/long", consumes = MediaType.MULTIPART_FORM_DATA)
	public HttpResponse<?> longVersion(@Body @Nullable Long quantity) {
		LOG.info("Success Quantity = [" + quantity + "]");
		return HttpResponse.ok(CollectionUtils.mapOf("Success Quantity", quantity));
	}
}
