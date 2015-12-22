import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

/**
 * Cell Class test Case
 *
 */
public class CellTest {

    @Test
    public void shouldCreateInstance() {

        Cell cell = new Cell(0,0);
        assertThat(cell.setValue('X'),is(true));
        assertThat(cell.getValue(),is('X'));
        assertThat(cell.getColumn(),is(0));
        assertThat(cell.getRow(),is(0));

        Cell cell1 = new Cell(1,1);
        assertNull(cell1.getValue());
        cell1.setValue('X');
        assertThat(cell1.getValue(), is('X'));

        Cell cell2  = new Cell(1,3);
        assertThat(cell2.setValue('Z'),is(false));
        assertThat(cell2.setValue('x'),is(false));
        cell2.setValue('X');
        assertThat(cell2.toString(),is(new String("1,3-X")));
    }


}