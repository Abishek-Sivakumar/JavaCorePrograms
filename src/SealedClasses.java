
sealed class Database permits Admin{

}

non-sealed class Admin extends Database{

}

final class Users extends Admin{

}

//

public class SealedClasses {
    public static void main(String[] args) {

    }
}
