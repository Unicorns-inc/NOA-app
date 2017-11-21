package pumpkin.noa;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import org.w3c.dom.Text;

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

        final PostTemplates member = getItem(position); // the post

        final TextView nameText = (TextView) listItemView.findViewById(R.id.title);
        nameText.setText(member.getTitle());

        TextView locatedText = (TextView) listItemView.findViewById(R.id.content);
        locatedText.setText(member.getContent());

        ImageView image = (ImageView)listItemView.findViewById(R.id.image);

        TextView sharedurl = (TextView)listItemView.findViewById(R.id.textView);
        sharedurl.setText(member.getUrl());
        Button button = (Button)listItemView.findViewById(R.id.buttonShare);
        Glide.with(parent).load(member.getUrl()).into(image);



        return listItemView;

    }
}
