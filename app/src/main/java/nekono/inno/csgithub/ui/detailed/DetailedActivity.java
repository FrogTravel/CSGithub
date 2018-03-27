package nekono.inno.csgithub.ui.detailed;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nekono.inno.csgithub.R;
import nekono.inno.csgithub.model.Issue;
import nekono.inno.csgithub.model.Labels;

/**
 * Created by ekaterina on 3/23/18.
 * Okey, so here was a choice, I could make a new request, or pass issue through intent
 * I choose second, 'cause it seems easier for me.
 */

public class DetailedActivity extends Activity implements DetailedScreen.View {
    @BindView(R.id.titleTextView) TextView titleTextView;
    @BindView(R.id.bodyTextView) TextView bodyTextView;
    @BindView(R.id.dateTextView) TextView dateTextView;
    @BindView(R.id.stateTextView) TextView stateTextView;
    @BindView(R.id.userLoginTextView) TextView loginTextView;
    @BindView(R.id.labelsLL) LinearLayout labelsLinearLayout;
    @BindView(R.id.avatarImageView) ImageView avatarImageView;

    private Issue issue;
    private DetailedScreen.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ButterKnife.bind(this);

        presenter = new DetailedPresenter(this);

        issue = (Issue) getIntent().getSerializableExtra("Issue");

        presenter.parseIssue(issue);
    }


    @Override
    public void setLogin(String login) {
        loginTextView.setText(login);
    }

    /**
     * Picasso for more convenient work with images. In case of error will show a placeholder
     */
    @Override
    public void showAvatar(String url) {
        Picasso.get()
                .load(url)
                .placeholder(getDrawable(R.drawable.default_image))
                .error(getDrawable(R.drawable.default_image))
                .into(avatarImageView);
    }

    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    @Override
    public void setBody(String body) {
        bodyTextView.setText(body);
    }

    @Override
    public void setState(String state) {
        stateTextView.setText(state);
    }

    /**
     * Comma will be added after every label, if not the last label
     */
    @Override
    public void setLabels(List<Labels> labels) {
        for (Labels label : labels) {
            TextView textView = new TextView(this);
            if (labels.indexOf(label) == labels.size() - 1)
                textView.setText(label.getName());
            else
                textView.setText(label.getName() + ", ");

            labelsLinearLayout.addView(textView);
        }
    }

    /**
     * Okay, I am lazy enough to get all dates as string and then to replace some chars everywhere
     */
    @Override
    public void setDate(String date) {
        date = date.replace("T", " ").replace("Z", " ");
        dateTextView.setText(date);
    }
}
