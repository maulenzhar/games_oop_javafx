package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void whenPositionC1() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell res = bishop.position();
        assertThat(Cell.C1, is(res));
    }

    @Test
    public void whenCopyFigure() {
        BishopBlack bishop = new BishopBlack(Cell.D5);
        Figure res = bishop.copy(Cell.A2);
        assertThat(Cell.A2, is(res.position()));
    }

    @Test
    public void whenWayRightUp() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] res = bishop.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expected, is(res));
    }

    @Test
    public void whenWayLeftUp() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] res = bishop.way(Cell.A3);
        Cell[] expected = {Cell.B2, Cell.A3};
        assertThat(expected, is(res));
    }

    @Test
    public void whenWayRightDown() {
        BishopBlack bishop = new BishopBlack(Cell.A3);
        Cell[] res = bishop.way(Cell.C1);
        Cell[] expected = {Cell.B2, Cell.C1};
        assertThat(expected, is(res));
    }

    @Test
    public void whenWayLeftDown() {
        BishopBlack bishop = new BishopBlack(Cell.G5);
        Cell[] res = bishop.way(Cell.C1);
        Cell[] expected = {Cell.F4,  Cell.E3, Cell.D2, Cell.C1};
        assertThat(expected, is(res));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayIsNotDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.G4);
    }
}