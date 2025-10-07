package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class Fly extends Module {
    private final Setting<Float> speed = num("Speed", 0.5f, 0.1f, 5.0f);

    public Fly() {
        super("Fly", "Allows you to fly like in creative mode", Category.MOVEMENT, true, false, false);
    }

    @Override
    public void onUpdate() {
        if (nullCheck()) return;

        mc.player.getAbilities().flying = true;

        mc.player.setVelocity(
            mc.player.getVelocity().x,
            (mc.options.jumpKey.isPressed() ? speed.getValue() : (mc.options.sneakKey.isPressed() ? -speed.getValue() : 0)),
            mc.player.getVelocity().z
        );
    }

    @Override
    public void onDisable() {
        if (nullCheck()) return;
        mc.player.getAbilities().flying = false;
    }
}
