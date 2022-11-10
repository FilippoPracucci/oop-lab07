package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;

        Month(final int days) {
            this.days = days;
        }

        Month fromString(final String monthName) {
            Objects.requireNonNull(monthName);
            try {
                return valueOf(monthName);
            } catch (IllegalArgumentException e) {
                Month monthMatch = null;
                for (final Month month : values()) {
                    if (month.toString().toLowerCase(Locale.ROOT).startsWith(monthName.toLowerCase(Locale.ROOT))) {
                        if (monthMatch != null) {
                            throw new IllegalArgumentException(
                                "Ambiguity for month " + monthName + ". Can be: " + monthMatch + ", and " + month, e
                            );
                        }
                        monthMatch = month;
                    }
                }
                if (monthMatch == null) {
                    throw new IllegalArgumentException("No match for month " + monthName, e);
                }
                return monthMatch;
            }
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
