class StringOperations {

    static class EngString {
        boolean english;
        String string;

        public EngString(boolean english, String string) {
            this.english = english;
            this.string = string;
        }

        public String getString() {
            return string;
        }

        public boolean isEnglish() {
            return english;
        }
    }
}