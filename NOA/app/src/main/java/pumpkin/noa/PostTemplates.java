package pumpkin.noa;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Admin on 08-11-2017.
 */

public class PostTemplates {

    private String title;
    private String content;
    private String url;

    public PostTemplates(String title, String content,String url)
    {
        this.title = title;
        this.content = content;
        this.url=url;

    }
    public PostTemplates()
    {

    }

    public String getTitle()
    {
        return this.title;
    }
    public String getContent()
    {
        return this.content;
    }
    public String getUrl()
    {
        return this.url;
    }

    public void setTitle(String title)
    {
        this.title=title;
    }
    public void setContent(String content)
    {
        this.content = content;
    }
    public void setUrl(String url)
    {
        this.url=url;
    }

}


