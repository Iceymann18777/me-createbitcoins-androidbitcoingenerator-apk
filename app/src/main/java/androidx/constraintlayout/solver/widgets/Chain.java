package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:192:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0390 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r35, androidx.constraintlayout.solver.LinearSystem r36, int r37, int r38, androidx.constraintlayout.solver.widgets.ChainHead r39) {
        /*
            Method dump skipped, instructions count: 1329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
