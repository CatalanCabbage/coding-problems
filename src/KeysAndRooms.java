import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Problem:
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 *
 * When you visit a room, you may find a set of distinct keys in it.
 * Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 *
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 *
 * Link: https://leetcode.com/problems/keys-and-rooms/
 */


class KeysAndRooms {
    private boolean[] isRoomOpened;
    private int numOfOpenRooms = 0;

    private boolean canVisitAllRooms(List<List<Integer>> rooms) {
        isRoomOpened = new boolean[rooms.size()];
        openRoom(0, rooms);
        return numOfOpenRooms == rooms.size();
    }

    private void openRoom(int room, List<List<Integer>> rooms) {
        if (isRoomOpened[room]) {
            return;
        } else {
            isRoomOpened[room] = true;
            numOfOpenRooms++;
        }
        List<Integer> keys = rooms.get(room);
        for (Integer key : keys) {
            openRoom(key, rooms);
        }
    }

    @Test
    @DisplayName("Check if rooms can be opened")
    void isValid() {
        List<List<Integer>> tc1 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Collections.emptyList()
        );
        List<List<Integer>> tc2 = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(3, 0, 1),
            Arrays.asList(2),
            Arrays.asList(0)
        );

        Assertions.assertAll(() -> assertTrue(canVisitAllRooms(tc1)),
            () -> assertFalse(canVisitAllRooms(tc2)));
    }
}
