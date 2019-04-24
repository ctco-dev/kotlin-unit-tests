
import com.home.utils.Calculator
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class TableExample : StringSpec() {
    init {
        "Should sum" {
            forall(
                    row(1, "2", 3),
                    row(-1, "-1", -2),
                    row(0, "0", 0)
            ) { left, right, expectedResult ->
                Calculator.sum(left, right).shouldBe(expectedResult)
            }
        }
    }
}