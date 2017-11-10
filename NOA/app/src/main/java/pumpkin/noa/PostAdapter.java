package pumpkin.noa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class PostAdapter extends ArrayAdapter<PostTemplates> {

    public PostAdapter(Activity context, ArrayList<PostTemplates> postTemplates) {
        super(context, 0, postTemplates);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;

        if(listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.postlist, parent, false);

        PostTemplates member = getItem(position); // the post

        TextView nameText = (TextView) listItemView.findViewById(R.id.title);
        nameText.setText(member.getTitle());

        TextView locatedText = (TextView) listItemView.findViewById(R.id.content);
        locatedText.setText(member.getContent());

        ImageView icon = (ImageView) listItemView.findViewById(R.id.image);
        icon.setImageResource(member.getImage());


        return listItemView;

    }
}
