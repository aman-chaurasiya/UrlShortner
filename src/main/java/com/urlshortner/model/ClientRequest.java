package com.urlshortner.model;


import com.urlshortner.Entity.Url;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientRequest {
    private Long id;
    private String name;
    private String host;
    private String port;
    private Long expireAfterMillis;

    private List<Url> urlList;

}
