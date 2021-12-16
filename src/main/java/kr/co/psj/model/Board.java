package kr.co.psj.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/*

 */
@Entity // JPA를 활용한 친구라는 것을 알려주어야 합니다.
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Board {
    //해당 친구가 PK라는 것을 알려주기 위하여 @Id어노테이션이 필요합니다.
    //auto_increment..>@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// Auto가 기본설정입니다.
    private Long id;
    private String title;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Board board = (Board) o;
        return id != null && Objects.equals(id, board.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

























