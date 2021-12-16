package kr.co.psj.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*

 */
@Entity // JPA를 활용한 친구라는 것을 알려주어야 합니다.
@Data
public class Board {
    //해당 친구가 PK라는 것을 알려주기 위하여 @Id어노테이션이 필요합니다.
    //auto_increment..>@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    private String title;
    private String content;


}

























