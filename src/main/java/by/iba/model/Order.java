package by.iba.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable; // для преобразования объекта в двоичный формат, который может быть сохранен на диск или отправлен по сети

@Data // дает геттеры и сеттеры для всех полей, правильные реализации toString, equals и hashCode + конструктор для всех финальных полей
//@ToString // сгенерирует нужную реализацию метода toString().
@AllArgsConstructor // будет сгенерирован конструктор с одним параметром для каждого поля вашего класса.
@NoArgsConstructor // Lombok возьмет на себя автоматическую генерацию непараметризованного конструктора.
public class Order implements Serializable{
    private int id;
    private int personId;
    private int sportOfferId;
    private int quantityOfDay; // количество дней
    private String month;

    public Order(int personId, int sportOfferId, int quantityOfDay, String month) {
        this.personId = personId;
        this.sportOfferId = sportOfferId;
        this.quantityOfDay = quantityOfDay;
        this.month = month;
    }

}
