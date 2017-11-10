package pumpkin.noa;

/**
 * Created by Admin on 08-11-2017.
 */

public class PostTemplates {

    private String title;
    private String content;
    private int image;

    public PostTemplates(String title, String content, int image)
    {
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public String getTitle() {return title;}
    public String getContent() {return content;}
    public int getImage() {return image;}
}


