package zw.co.afrosoft.springjpacourse.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Lecture extends BaseEntity {
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToOne(mappedBy = "lecture")
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
