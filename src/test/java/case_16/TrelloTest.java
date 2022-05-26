package case_16;


import io.restassured.response.Response;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;

public class TrelloTest {

    private String key="5880ea19b5f3c8053f1dd9db5f498174";
    private String token="bc5c5c40895d5d13f8244463bf3c145ffd07449f057c858ebb1934cb1c7d37a1";
    private Response response;
    private String boardId;
    private String boardName = "newBoard";



    @Test(priority = 1)
    void createBoard(){
//https://api.trello.com/1/boards/?name={{boardName}}&key={{key}}&token={{token}}

               response = given()
                .when()
                .contentType("application/json")
                .body("{\"idOrganization\": \"62900c31af795a4523fadb26\"}")
                .post("https://api.trello.com/1/boards/?name="+boardName+"&key="+key+"&token="+token).
                then()
                .assertThat()
                .statusCode(200)
                       .extract().response();

                boardId = response.getBody().jsonPath().get("id");
        System.out.println("board id " + boardId);
    }

    @Test(priority = 2)
    void getBoard(){
      //  https://api.trello.com/1/boards/{{boardId}}?key={{key}}&token={{token}}

        given()
                .when()
                .get("https://api.trello.com/1/boards/"+boardId+"?key="+key+"&token="+token)
                .then()
                .assertThat()
                .statusCode(200);

    }

    @Test(priority = 3)
    void putBoard(){
        //https://api.trello.com/1/boards/{{boardId}}?name={{boardName}}&key={{key}}&token={{token}}
            boardName = "oldBoard";
        given()
                .when()
                .put("https://api.trello.com/1/boards/"+boardId+"?name="+boardName+"&key="+key+"&token="+token)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(priority = 4)
    void deleteBoard(){
        //https://api.trello.com/1/boards/{{boardId}}?key={{key}}&token={{token}}
        given()
                .when()
                .delete("https://api.trello.com/1/boards/"+boardId+"?key="+key+"&token="+token)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
