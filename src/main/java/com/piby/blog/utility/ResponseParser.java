package com.piby.blog.utility;

import com.sun.jmx.snmp.Timestamp;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * @author      Lorenzo D'Isidoro <lorenzo.disidoro@gmail.com>
 * @version     1.2
 * @since       1.0
 *   ________________________/ O  \___/
    <_/_\_/_\_/_\_/_\_/_\_/_______/   \
    Snake crushes your ResponseEntity
 *
 */
public class ResponseParser {

    public ResponseParser() {}

    /**
     * Structure the response ResponseEntity
     *
     * @param HttpMethod (GET, DELETE, ...)
     * @param isSuccess utility boolean for success
     * @param data data to return
     * @param activeLog utility to enable action log in console
     *
     * @return ResponseEntity to be used directly in the controller
     */
    public ResponseEntity<?> generateResponseEntity(String HttpMethod, boolean isSuccess, Object data, boolean activeLog) {

        HttpStatus status;
        String message;

        switch (HttpMethod) {
            case "GET":
                message = isSuccess ? "Entity found" : "Entity not found";
                status = isSuccess ? HttpStatus.FOUND : HttpStatus.NOT_FOUND;
                if (activeLog) { System.out.println("[" + HttpMethod + "] " + message + " - [HttpStatus] " + status); }
                return ResponseEntity.status(status)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.generateResponseBodyJsonObj(message, isSuccess, data, status));
            case "POST":
                message = isSuccess ? "Entity created" : "Entity not created";
                status = isSuccess ? HttpStatus.CREATED : HttpStatus.NOT_ACCEPTABLE;
                if (activeLog) { System.out.println("[" + HttpMethod + "] " + message + " - [HttpStatus] " + status); }
                return ResponseEntity.status(status)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.generateResponseBodyJsonObj(message, isSuccess, data, status));
            case "PUT":
            case "PATCH":
                message = isSuccess ? "Entity updated" : "Entity not updated";
                status = isSuccess ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
                if (activeLog) { System.out.println("[" + HttpMethod + "] " + message + " - [HttpStatus] " + status); }
                return ResponseEntity.status(status)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.generateResponseBodyJsonObj(message, isSuccess, data, status));
            default:
                message = "HttpMethod not matched in Class ResponseParser <ResponseEntity()>";
                status = HttpStatus.HTTP_VERSION_NOT_SUPPORTED;
                if (activeLog) { System.out.println("[" + HttpMethod + "] " + message + " - [HttpStatus] " + status); }
                return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.generateResponseBodyJsonObj(message, false, new Object(), status));
        }

    }


    /**
     * Structure the response body
     *
     * @param message utility string message
     * @param isSuccess utility boolean for success
     * @param data data to return
     *
     * @return JSON Object response
     */
    public JSONObject generateResponseBodyJsonObj(String message, boolean isSuccess, Object data, HttpStatus status) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        JSONObject response = new JSONObject();
        response.put("error", !isSuccess);
        response.put("message", message);
        response.put("status", status);
        response.put("timestamp", timestamp.getDate());
        response.put("data", data);
        return response;
    }


}
