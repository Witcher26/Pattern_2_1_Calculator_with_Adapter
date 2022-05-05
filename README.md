# Pattern_2_1_Calculator_with_Adapter
1.2: Структурные шаблоны. Adapter, Proxy, Decorator, Facade, Flyweight  
Применение шаблона Adapter.

# Задача Калькулятор

## Описание
В этом задании попрактикуемся с шаблоном *Adapter* (*Адаптер*). Необходимо взять стандартный класс калькулятора,

```java
public class Calculator {
  public Formula newFormula() {
    return new Formula();
  }

  public static enum Operation {
    // ваш код
  }

  public static class Formula {
    protected Double a, b, result;

    protected Formula() {}

    public Formula addOperand(double operand) {
      if (a == null) {
       // ваш код
      } else if (b == null) {
        // ваш код
      } else {
        throw new IllegalStateException("Formula is full of operands");
      }
      // ваш код
    }

    public Formula calculate(Operation op) {
      if (a == null || b == null)
        throw new IllegalStateException("Not enough operands!");
      switch (op) {
        case SUM:
          result = a + b;
          break;
        // ваш код
        
        case POW:
          result = Math.pow(a, b);
          break;
      }
      return this;
    }

    public double result() {
      if (result == null)
        throw new IllegalStateException("Formula is not computed!");
      return result;
    }
  }
}
```

Пример использования этого класса:
```java
Calculator calc = new Calculator();
System.out.println(
  calc.newFormula()
    .addOperand(5)
    .addOperand(15)
    .calculate(Calculator.Operation.MULT)
    .result()
);
```

Пользователю же нужен другой интерфейс для работы с калькулятором:
```java
public interface Ints {
  int sum(int arg0, int arg1);
  int mult(int arg0, int arg1);
  int pow(int a, int b);
}
``` 
который он использует в `main`, например, вот так:
```java
public static void main(String[] args) {
  Ints intsCalc = new IntsCalculator();
  System.out.println(intsCalc.sum(2, 2));
  System.out.println(intsCalc.sum(10, 22));
  System.out.println(intsCalc.pow(2, 10));
}
```

Вам надо написать класс `IntsCalculator`, который будет имплементировать интерфейс `Ints`, "под капотом" делая вычисления через класс `Calculator`.
