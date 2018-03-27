package nekono.inno.csgithub.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import nekono.inno.csgithub.R;
import nekono.inno.csgithub.model.Issue;

/**
 * Created by ekaterina on 3/22/18.
 * Context is used for more convenient click capturing
 */

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.IssueViewHolder> {

    MainScreen.Presenter presenter;

    public IssueAdapter(MainScreen.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public IssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.issue_card, parent, false);

        return new IssueViewHolder(v, presenter);
    }

    @Override
    public void onBindViewHolder(IssueViewHolder holder, int position) {
        Issue issue = presenter.getIssue(position);
        holder.bodyTextView.setText(issue.getBody());

        holder.dateTextView.setText(issue.getCreated_at().toString());
        holder.stateTextView.setText(issue.getState());
        holder.titleTextView.setText(issue.getTitle());
    }

    @Override
    public int getItemCount() {
        return presenter.getIssuesSize();
    }

    public class IssueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.bodyTextView) TextView bodyTextView;
        @BindView(R.id.titleTextView) TextView titleTextView;
        @BindView(R.id.dateTextView) TextView dateTextView;
        @BindView(R.id.stateTextView) TextView stateTextView;

        MainScreen.Presenter presenter;

        public IssueViewHolder(View itemView, MainScreen.Presenter presenter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

            this.presenter = presenter;
        }


        @Override
        public void onClick(View view) {
            presenter.issueClicked(presenter.getIssue(getAdapterPosition()));
        }
    }
}
