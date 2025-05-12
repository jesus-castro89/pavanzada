package org.brick_breaker.utils.collisions;

import org.brick_breaker.sprites.Borders;
import org.brick_breaker.sprites.Sprite;
import org.brick_breaker.ui.panels.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollisionManager {
    private static CollisionManager instance;
    private final CopyOnWriteArrayList<CollisionListener> listeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<Sprite> collidableObjects = new CopyOnWriteArrayList<>();

    private CollisionManager() {
    }

    public static CollisionManager getInstance() {
        if (instance == null) {
            instance = new CollisionManager();
        }
        return instance;
    }

    public void clearCollidableObjects() {
        collidableObjects.clear();
    }

    public void clearListeners() {
        listeners.clear();
    }

    public void registerCollidable(Sprite object) {
        collidableObjects.add(object);
    }

    public void unregisterCollidable(Sprite object) {
        collidableObjects.remove(object);
    }

    public void addListener(CollisionListener listener) {
        listeners.add(listener);
    }

    public void removeListener(CollisionListener listener) {
        listeners.remove(listener);
    }

    public void checkCollisions() {
        for (int i = 0; i < collidableObjects.size(); i++) {
            Sprite obj1 = collidableObjects.get(i);
            // Verificar colisión con bordes
            checkBorderCollisions(obj1);
            // Verificar colisión con otros objetos
            for (int j = i + 1; j < collidableObjects.size(); j++) {
                Sprite obj2 = collidableObjects.get(j);
                if (obj1.getBounds().intersects(obj2.getBounds())) {
                    EdgeType collisionSide = determineCollisionSide(obj1.getBounds(), obj2.getBounds());
                    notifyListeners(obj1, obj2, collisionSide);
                    notifyListeners(obj2, obj1, inverseCollisionSide(collisionSide));
                }
            }
        }
    }

    private void checkBorderCollisions(Sprite obj) {

        Rectangle bounds = obj.getBounds();
        if (bounds.x <= 0)
            notifyListeners(obj, null, EdgeType.LEFT_EDGE);
        if (bounds.y <= 0)
            notifyListeners(obj, null, EdgeType.TOP_EDGE);
        if (bounds.x + bounds.width >= GamePanel.GAME_WIDTH)
            notifyListeners(obj, null, EdgeType.RIGHT_EDGE);
        if (bounds.y + bounds.height >= GamePanel.HEIGHT - Borders.BOTTOM_BAR.getBounds().height)
            notifyListeners(obj, null, EdgeType.BOTTOM_EDGE);
    }

    private void notifyListeners(Sprite collider, Sprite collidedWith, EdgeType side) {
        // Crear una copia de la lista de listeners para evitar ConcurrentModificationException
        List<CollisionListener> listenersCopy = new ArrayList<>(listeners);
        for (CollisionListener listener : listenersCopy) {
            listener.onCollisionDetected(collider, collidedWith, side);
        }
    }


    private EdgeType determineCollisionSide(Rectangle obj1, Rectangle obj2) {
        int leftImpact = obj1.x + obj1.width - obj2.x;
        int rightImpact = obj2.x + obj2.width - obj1.x;
        int topImpact = obj1.y + obj1.height - obj2.y;
        int bottomImpact = obj2.y + obj2.height - obj1.y;
        int[] impacts = {leftImpact, rightImpact, topImpact, bottomImpact};
        int minImpact = Integer.MAX_VALUE;
        EdgeType edgeType = EdgeType.LEFT_EDGE;
        for (int i = 0; i < impacts.length; i++) {
            if (impacts[i] < minImpact) {
                minImpact = impacts[i];
                edgeType = EdgeType.values()[i];
            }
        }
        return edgeType;
    }

    private EdgeType inverseCollisionSide(EdgeType side) {
        return switch (side) {
            case LEFT_EDGE -> EdgeType.RIGHT_EDGE;
            case RIGHT_EDGE -> EdgeType.LEFT_EDGE;
            case TOP_EDGE -> EdgeType.BOTTOM_EDGE;
            case BOTTOM_EDGE -> EdgeType.TOP_EDGE;
        };
    }
}