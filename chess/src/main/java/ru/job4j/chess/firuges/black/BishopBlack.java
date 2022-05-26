package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (position.getX() < dest.getX()) ? position.getX() + 1 : position.getX() - 1;
        int deltaY = (position.getY() < dest.getY()) ? position.getY() + 1 : position.getY() - 1;
        for (int index = 0; index < size; index++) {
            if (position.getX() < dest.getX() && position.getY() > dest.getY()) {
                steps[index] = Cell.findBy(deltaX + index, deltaY - index);
            } else if (position.getX() > dest.getX() && position.getY() < dest.getY()) {
                steps[index] = Cell.findBy(deltaX - index, deltaY + index);
            } else if (position.getX() > dest.getX() && position.getY() > dest.getY()) {
                steps[index] = Cell.findBy(deltaX - index, deltaY - index);
            } else {
                steps[index] = Cell.findBy(deltaX + index, deltaY + index);
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (abs(source.getX() - dest.getX()) == abs(source.getY() - dest.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
