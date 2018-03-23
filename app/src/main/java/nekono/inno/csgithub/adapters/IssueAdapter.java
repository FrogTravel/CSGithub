package nekono.inno.csgithub.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nekono.inno.csgithub.R;
import nekono.inno.csgithub.model.Issue;
import nekono.inno.csgithub.ui.main.presenter.MainActivityPresenter;
import nekono.inno.csgithub.ui.main.presenter.MainActivityPresenterImpl;
import nekono.inno.csgithub.ui.main.view.MainActivity;

/**
 * Created by ekaterina on 3/22/18.
 */

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.IssueViewHolder> {
    List<Issue> issues;
    Context context;

    public IssueAdapter(List<Issue> issues, Context context) {
        this.issues = issues;
        this.context = context;
    }


    @Override
    public IssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.issue_card, parent, false);

        IssueViewHolder issueViewHolder = new IssueViewHolder(v, context);
        return issueViewHolder;
    }

    @Override
    public void onBindViewHolder(IssueViewHolder holder, int position) {
        Issue issue = issues.get(position);
        holder.bodyTextView.setText(issue.getBody());

        holder.dateTextView.setText(issue.getCreated_at());
        holder.stateTextView.setText(issue.getState());
        holder.titleTextView.setText(issue.getTitle());
    }

    @Override
    public int getItemCount() {
        return issues.size();
    }

    public class IssueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.bodyTextView)
        TextView bodyTextView;
        @BindView(R.id.titleTextView)
        TextView titleTextView;
        @BindView(R.id.dateTextView)
        TextView dateTextView;
        @BindView(R.id.stateTextView)
        TextView stateTextView;

        OnIssueClickListener onIssueClickListener;


        public IssueViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            onIssueClickListener = (OnIssueClickListener) context;
        }


        @Override
        public void onClick(View view) {
            onIssueClickListener.onIssueClick(issues.get(getAdapterPosition()));
        }
    }

    public interface OnIssueClickListener {
        void onIssueClick(Issue issue);
    }
}
