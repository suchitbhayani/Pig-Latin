import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    String toTranslate = "I love baron guo!";
    System.out.println("English: " + "\n" + toTranslate);
    
    System.out.println("Pig Latin: ");
    String[] words = toTranslate.split(" ");
    for (int i = 0; i < words.length; i++) {
      System.out.print(pigLatinOf(words[i]) + " ");
    }
  }

  public static String pigLatinOf(String word) {
    ArrayList<Character> vowelList = createVowelList();
    ArrayList<Character> punctuationList = createPunctuationList();
  
    boolean firstCharIsVowel = false;
    boolean secondCharIsVowel = false;
    boolean isUpperCase = false;
    boolean punctuationExists = false;
    
    int phraseLength = word.length();
    Character lastChar = word.charAt(phraseLength - 1);
    Character punctuation = null;
    for (Character possiblePunctuation : punctuationList) {  
      if (lastChar == possiblePunctuation) {
        punctuation = possiblePunctuation;
        word = word.substring(0, phraseLength - 1);
        punctuationExists = true;
        break;
      }
    }

    char[] characters = word.toCharArray();
    if (Character.isUpperCase(characters[0])) {
      isUpperCase = true;
      characters[0] = Character.toLowerCase(characters[0]);
    }

    int wordLength = characters.length;
    
    char firstChar = characters[0];
    for (Character vowel : vowelList) {
      if (firstChar == vowel) {
        firstCharIsVowel = true;
        break;
      }
    }

    char secondChar = '#'; // placeholder value for secondChar
    if (wordLength > 1) {
      secondChar = characters[1];
      for (Character vowel : vowelList) {
        if (secondChar == vowel) {
          secondCharIsVowel = true;
          break;
        }
      }  
    }
    
    if (firstCharIsVowel == false && secondCharIsVowel == true) {
      for (int i = 0; i < wordLength - 1; i++) {
        characters[i] = characters[i + 1];
      }
      characters[wordLength - 1] = firstChar;
      if (isUpperCase) {
        characters[0] = Character.toUpperCase(characters[0]);
      }
      String newWord = new String(characters);
      if (punctuationExists) {
        return newWord + 'a' + 'y' + punctuation;
      }
      return newWord + 'a' + 'y';
    }

    if (firstCharIsVowel == false && secondCharIsVowel == false) {
      for (int i = 0; i < wordLength - 2; i++) {
        characters[i] = characters[i + 2];
      }
      characters[wordLength - 2] = firstChar;
      characters[wordLength - 1] = secondChar;
      if (isUpperCase) {
        characters[0] = Character.toUpperCase(characters[0]);
      }
      String newWord = new String(characters);
      if (punctuationExists) {
        return newWord + 'a' + 'y' + punctuation;
      }
      return newWord + 'a' + 'y';
    }

    if (firstCharIsVowel == true) {
      if (isUpperCase) {
        characters[0] = Character.toUpperCase(characters[0]);
      }
      String newWord = new String(characters);
      if (punctuationExists) {
        return newWord + 'w' + 'a' + 'y' + punctuation;
      }
      return newWord + 'w' + 'a' + 'y';
    }
    return null;
  }

  public static ArrayList<Character> createVowelList() {
    ArrayList<Character> vowelList = new ArrayList<>();
    vowelList.add('a');
    vowelList.add('e');
    vowelList.add('i');
    vowelList.add('o');
    vowelList.add('u');
    return vowelList;
  }

  public static ArrayList<Character> createPunctuationList() {
    ArrayList<Character> punctuationList = new ArrayList<>();
    punctuationList.add('.');
    punctuationList.add(',');
    punctuationList.add('!');
    punctuationList.add(';');
    punctuationList.add('?');
    return punctuationList;
  }
}