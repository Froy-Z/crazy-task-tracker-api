package my.code.crazy.task.tracker.store.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter // добавление сеттеров lombok
@Getter // добавление геттеров lombok
@Builder // паттер проектирования builder lombok
@NoArgsConstructor // конструктор по умолчанию без аргументов lombok
@AllArgsConstructor // конструктор по умолчнию для всех полей lombok
@Entity // определение класса как сущности
@Table(name = "project") // определение таблицы с её названием
public class ProjectEntity  {
    @Id // каждая запись в БД маркируется id, для идентификации
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // автоматическое создание id по стратегии
    // в данном случае identity для столбцов с автоинкрементом в БД PostgreSQL
    private Long id;

    @Column(unique = true)
    // обозначение уникального столбца и его название
    private String name;

    @Builder.Default // обозначение классу строителю, что значение Instant.now() будет принято по умолчанию
    private Instant createAt = Instant.now(); // момент времени

    @Builder.Default
    @OneToMany // аннотация один ко многим по типу корзины с яйцами
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    // настройка маппинга между связанными сущностями в реляционной БД
    // вследствии чего project_id будет добавлен в таблицу task_state
    // а лишняя таблица будет удалена
    private List<TaskStateEntity> taskStates = new ArrayList<>();
}

