package kr.co.psj.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/*

 */
@Entity // JPA를 활용한 친구라는 것을 알려주어야 합니다.
@Data
public class Board {
    //해당 친구가 PK라는 것을 알려주기 위하여 @Id어노테이션이 필요합니다.
    //auto_increment..>@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2 ,max = 30)
    private String title;
    private String content;


}

























