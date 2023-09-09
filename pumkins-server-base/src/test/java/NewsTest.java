import com.pumkins.config.newsapi.NewsApiClient;
import com.pumkins.config.newsapi.callback.ArticlesResponseCallback;
import com.pumkins.config.newsapi.dto.Article;
import com.pumkins.config.newsapi.dto.request.TopHeadlinesRequest;
import com.pumkins.config.newsapi.dto.response.ArticleResponse;

/**
 * @author: dengKai
 * @date: 2023/08/06 18:02
 * @description: TODO
 */

public class NewsTest {
    public static void main(String[] args) throws Exception {
        getHeadLine();
    }


    public static void getHeadLine() throws Exception {
        String key = "840378fad1ef48aaa6faba6daee85305";
        NewsApiClient newsApiClient = new NewsApiClient(key);
        TopHeadlinesRequest topHeadlinesRequest = new TopHeadlinesRequest()
            .setCountry("us")
            .setPageSize("10")
            .setLanguage("en");
        newsApiClient.getTopHeadlines(
            topHeadlinesRequest,
            new ArticlesResponseCallback() {
                @Override
                public void onSuccess(ArticleResponse response) {
                    for (Article article : response.getArticles()) {
                        System.out.println(article.getTitle());
                        System.out.println(article.getUrl());
                        System.out.println(article.getSource());
                    }


                    System.out.println(response.getArticles().get(0).getTitle());
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println(throwable.getMessage());
                }
            }
        );
    }
}
