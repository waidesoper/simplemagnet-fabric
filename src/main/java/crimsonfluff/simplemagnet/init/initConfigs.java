package crimsonfluff.simplemagnet.init;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.TranslatableText;

public class initConfigs {
    public static void init() {
        ConfigBuilder builder = ConfigBuilder.create()
                .setTitle(new TranslatableText("title.simplemagnet.config"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
    }
}
