package com.xzj.springboot.enums;

import java.util.Arrays;
import java.util.List;

public enum ColourEnum {
    DEFAULT_COLOURS("默认配色",new String[]{"#c23531", "#2f4554", "#d48265", "#91c7ae", "#749f83", "#ca8622", "#bda29a", "#6e7074", "#546570", "#c4ccd3"}),
    CLASSICS_COLOURS("经典配色",new String[]{"#63b2ee", "#76da91", "#f8cb7f", "#f89588", "#7cd6cf", "#9192ab", "#7898e1", "#efa666", "#eddd86", "#9987ce"}),
    GOBI_COLOURS("秋风戈壁",new String[]{"#b2bf59", "#f29d38", "#ecd48d", "#6ea740", "#ebc582", "#a57051", "#75cd62", "#f2d37f", "#d4a082", "#64dec8"}),
    GRACE_COLOURS("优雅格调",new String[]{"#5a8c8c", "#bcbfa4", "#f2d88d", "#bfa288", "#a98a61", "#7e5f42", "#d6c289", "#594653", "#366d73", "#004966"}),
    WARM_COLOURS("暖调糖水",new String[]{"#ffaaaa", "#789bf2", "#73ddc3", "#facb7c", "#ffa8e1", "#a8bdef", "#7ddec6", "#f4d6a1", "#ffc8aa", "#beafff"}),
    REEF_COLOURS("深海礁石",new String[]{"#366d73", "#e6b632", "#b9bb83", "#40beb3", "#055775", "#4084be", "#469ff4", "#f1d17a", "#365373", "#9bc2e2"}),
    FLIRT_COLOURS("风情海滩",new String[]{"#ff9b88", "#ffd543", "#5bd4d6", "#74a1f7", "#a0bbd1", "#8e72c0", "#4081be", "#8adbe4", "#91b9ff", "#365373"}),
    JUNGLE_COLOURS("丛林深处",new String[]{"#4bb190", "#5a85ab", "#bfbfbf", "#7ed7ba", "#278466", "#7abdf8", "#4d6e8a", "#d1d1d1", "#4a9b9b", "#76d4e8"}),
    GLOOMY_COLOURS("忧郁蓝调",new String[]{"#3895e0", "#005297", "#15b6ac", "#62dbe9", "#4081be", "#bce1ff", "#3b8ba1", "#53decf", "#add9ff", "#5477cd"}),
    MODERN_COLOURS("轻快现代",new String[]{"#ff9d35", "#f7d542", "#5ba4ff", "#35ccb5", "#f0ae30", "#00b1cc", "#918def", "#2ecf82", "#f9ce3a", "#43b8ab"}),
    SPRING_COLOURS("春日花园",new String[]{"#9bdc6d", "#3bbfbf", "#f2b05e", "#d9d488", "#f58ea1", "#b2a7d9", "#c9c047", "#49bf9e", "#f2836b", "#70a6e7"}),
    PARIS_COLOURS("巴黎海岸",new String[]{"#8e72c0", "#5bd4d6", "#ff9b88", "#74a1f7", "#ffd543", "#aaaaaa", "#367ce7", "#dab1ff", "#97e6ef", "#6495ca"});

    String style;
    String[] colours;

    ColourEnum(String style, String[] colours){
        this.style = style;
        this.colours = colours;
    }

    public String getStyle(){
        return style;
    }

    public List<String> getColours(){
        return Arrays.asList(colours);
    }
}
