package by.iba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data // дает геттеры и сеттеры для всех полей, правильные реализации toString, equals и hashCode + конструктор для всех финальных полей
//@ToString // сгенерирует нужную реализацию метода toString().
@AllArgsConstructor // будет сгенерирован конструктор с одним параметром для каждого поля вашего класса.
@NoArgsConstructor // Lombok возьмет на себя автоматическую генерацию непараметризованного конструктора.
public class SportOffer implements Serializable {
    private int id;
    private String nameOffer;  // название услуги
    private float price;  // цена за посещение

    public SportOffer(String name, float price) {
        this.nameOffer = name;
        this.price = price;
    }
}
