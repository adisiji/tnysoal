package nb.scode.tanyasoal.baseAct;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nb.scode.tanyasoal.R;

public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.ViewHolder> {

    private String[] titles;
    private Context context;

    // The default constructor to receive titles,icons and context from MainActivity.
    public NavDrawerAdapter(String[] titles , Context context){

        this.titles = titles;
        this.context = context;
    }

    /**
     *Its a inner class to NavDrawerAdapter Class.
     *This ViewHolder class implements View.OnClickListener to handle click events.
     *If the itemType==1 ; it implies that the view is a single row_item with TextView and ImageView.
     *This ViewHolder describes an item view with respect to its place within the RecyclerView.
     *For every item there is a ViewHolder associated with it .
     */

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView  navTitle;
        Context context;

        public ViewHolder(View drawerItem, Context context){

            super(drawerItem);

            this.context = context;

            navTitle = (TextView) itemView.findViewById(R.id.tv_NavTitle);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemLayout = layoutInflater.inflate(R.layout.nav_drawer_row, null);

            return new ViewHolder(itemLayout,  context);

    }

    /**
     *This method is called by RecyclerView.Adapter to display the data at the specified position.
     *This method should update the contents of the itemView to reflect the item at the given position.
     *So here , if position!=0 it implies its a row_item and we set the title and icon of the view.
     */

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.navTitle.setText(titles[position]);

    }

    @Override
    public int getItemCount() {

        return titles.length;
    }

}