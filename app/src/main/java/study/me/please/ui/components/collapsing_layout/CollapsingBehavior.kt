package study.me.please.ui.components.collapsing_layout

/** Type of scrolling behavior for [CollapsingLayout] */
enum class CollapsingBehavior {
    /** Always enters the scroll, either as scrolling out or in */
    ALWAYS,
    /** Enters scroll only at the very top of the scrolling content */
    ON_TOP,
    /** Never enters scroll */
    NONE
}