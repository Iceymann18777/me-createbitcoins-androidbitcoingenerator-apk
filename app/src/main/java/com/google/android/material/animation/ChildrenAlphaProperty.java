package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    public Float get(@NonNull ViewGroup viewGroup) {
        Float f = (Float) viewGroup.getTag(C0369R.C0371id.mtrl_internal_children_alpha_tag);
        return f != null ? f : Float.valueOf(1.0f);
    }

    public void set(@NonNull ViewGroup viewGroup, Float f) {
        float floatValue = f;
        viewGroup.setTag(C0369R.C0371id.mtrl_internal_children_alpha_tag, floatValue);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(floatValue);
        }
    }
}
