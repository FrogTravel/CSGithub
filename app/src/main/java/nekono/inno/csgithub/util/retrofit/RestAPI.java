package nekono.inno.csgithub.util.retrofit;

import java.util.List;

import io.reactivex.Observable;
import nekono.inno.csgithub.model.Issue;
import retrofit2.http.GET;

/**
 * Created by ekaterina on 3/22/18.
 * https://api.github.com
 * https://api.github.com/repos/ReactiveX/RxJava/issues/5929
 * https://api.github.com/users/$USER/repos?per_page=100
 */

public interface RestAPI {
    @GET("/repos/ReactiveX/RxJava/issues?per_page=100")
    Observable<List<Issue>> getIssues();
}
