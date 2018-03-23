package nekono.inno.csgithub.model.retrofit;

import java.util.List;

import io.reactivex.Observable;
import nekono.inno.csgithub.model.Issue;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ekaterina on 3/22/18.
 */

public interface RestAPI {
    @GET("/repos/ReactiveX/RxJava/issues")
    Observable<List<Issue>> getIssues();
}
