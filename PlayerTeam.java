    public enum PlayerTeam {
        White("W"), Black("B");

        private String value;

        PlayerTeam(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

