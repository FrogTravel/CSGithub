package nekono.inno.csgithub.util.retrofit;

import java.util.List;

import io.reactivex.Observable;
import nekono.inno.csgithub.model.Issue;
import retrofit2.http.GET;

/**
 * Created by ekaterina on 3/22/18.
 */

public interface RestAPI {
    /**
     * @return the array of objects with all information about issue
     */
    @GET("/repos/ReactiveX/RxJava/issues?per_page=100")
    Observable<List<Issue>> getIssues();
}
