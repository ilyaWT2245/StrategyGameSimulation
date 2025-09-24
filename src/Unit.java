import java.util.Random;
public class Unit {
    int startQuantity;
    int startDamage;
    int startActionPoints;


    int quantity;
    int damage;
    int armour;
    int range;
    int actionPoints;
    Tile position;
    boolean status;


    protected  void Attack(Unit damagedUnit, Unit attackingUnit) {
        attackingUnit.actionPoints -= 1;
        Random rand = new Random();
        int damageBoost = rand.nextInt(10);
        damagedUnit.quantity -= (attackingUnit.damage + damageBoost - damagedUnit.armour);
        CheckUnitQuantityDegradation(damagedUnit);
        CheckUnitStatus(damagedUnit);
    }

    protected  void CheckUnitQuantityDegradation(Unit checkedUnit){
        // Описать процесс деградации юнитов относительно первоначальной численности. Влияет на все статы, кроме брони и дальности.
        // Имеет 4 стадии: 100%, 75%, 50%, 25%. При переходе каждый раз меняется на фиксированную величину.
    }

    protected void CheckDistance(Unit attackingUnit, Unit attackedUnit){
        // После описания карты описать процесс проверки на "доставание до противника". 
        // Достает если тайлов до врага <= дальность юнита + модификатор тайла под юнитом.
        // После описания добавить в функцию Attack.
    }

    protected void Move(Unit movingUnit, Tile destination){
        movingUnit.actionPoints -= 1;
        // Описать проверку на то, граничит ли тайл назначения с тайлом позиции. 
        // Если да, заменить "позицию" юнита на новый тайл.
    }

    protected void CheckUnitStatus(Unit CheckedUnit){
        // True - юнит жив и на поле.
        // False - юнит убирается с поля.
    }

    protected void CheckUnitPositionBenefits(Unit CheckeUnit){
        // Описать как позиция влияет на юнита.
        // Добавить функцию как проверку в Attack, CheckDistance, и пр.
    }
}