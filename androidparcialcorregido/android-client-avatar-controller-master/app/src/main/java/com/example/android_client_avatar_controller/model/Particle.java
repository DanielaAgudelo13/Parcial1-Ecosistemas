/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.android_client_avatar_controller.model;

public class Particle {

    // -------------------------------------
    // Attributtes
    // -------------------------------------
    private String groupName;
    private int numParticles;
    private int posX;
    private int posY;
    private String type;

    // -------------------------------------
    // Constructor
    // -------------------------------------
    public Particle() {

    }

    public Particle(String groupName, int numParticles, int posX, int posY, String type) {
        this.groupName = groupName;
        this.numParticles = numParticles;
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }

    // -------------------------------------
    // Getters and setters
    // -------------------------------------

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getNumParticles() {
        return numParticles;
    }

    public void setNumParticles(int numParticles) {
        this.numParticles = numParticles;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
