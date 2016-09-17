package com.cryotech;

/**
 * Created by Cryotech on 8/18/2016.
 */

public class GridGraphics {

    private char[][] m_grid;

    public GridGraphics() {
        m_grid = null;
    }

    public GridGraphics(int r, int c) {
        m_grid = new char[r][c];
    }

    public GridGraphics(int r, int c, char a) {
        m_grid = new char[r][c];
        SetFill(a);
    }

    public int GetR() {
        return m_grid.length;
    }

    public int GetC() {
        return m_grid[0].length;
    }

    public void Draw() {
        if (m_grid == null)
            throw new RuntimeException("Array does not exist!");

        for (int i = 0; i < m_grid.length; ++i)
            System.out.println(m_grid[i]);
    }

    public void SetFill(char a) {
        if (m_grid == null)
            throw new RuntimeException("Array does not exist!");

        for (int i = 0; i < m_grid.length; ++i)
            for (int ii = 0; ii < m_grid[0].length; ++ii)
                m_grid[i][ii] = a;
    }

    public void SetChar(int r, int c, char a) {
        if (m_grid == null)
            throw new RuntimeException("Array does not exist!");
        if (r < 0 || c < 0 ||
                m_grid.length <= r || m_grid[0].length <= c)
            throw new ArrayIndexOutOfBoundsException("Index out of bounds!");

        m_grid[r][c] = a;
    }

    public void SetBox(int r1, int c1, int r2, int c2, char a) {
        if (m_grid == null)
            throw new RuntimeException("Array does not exist!");
        if (r1 < 0 || c1 < 0 || r2 < 0 || c2 < 0 ||
                m_grid.length <= r1 || m_grid[0].length <= c1 || m_grid.length <= r2 || m_grid[0].length <= c2)
            throw new ArrayIndexOutOfBoundsException("Index out of bounds!");

        if (r1 > r2) {
            r1 ^= r2;
            r2 ^= r1;
            r1 ^= r2;
        }
        if (c1 > c2) {
            c1 ^= c2;
            c2 ^= c1;
            c1 ^= c2;
        }

        for (int i = r1; i <= r2; ++i)
            for (int ii = c1; ii <= c2; ++ii)
                m_grid[i][ii] = a;
    }

    public void SetString(int r, int c, String a) {
        if (m_grid == null)
            throw new RuntimeException("Array does not exist!");
        if(a.length() == 0)
            throw new RuntimeException("No string given!");
        if (r < 0 || c < 0 ||
                m_grid.length <= r || m_grid[0].length <= c + a.length() - 1)
            throw new ArrayIndexOutOfBoundsException("Index out of bounds!");

        for(int i = 0; i < a.length(); ++i)
            m_grid[r][c + i] = a.toCharArray()[i];
    }
}
