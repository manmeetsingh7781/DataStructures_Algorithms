package HashMaps;


public class HashFunctions<K> {

    private int table_size = 10;
    private K key;

    public HashFunctions(K key) {
        this.key = key;
    }


    /**
     * very common and simple technique
     * Used in when dealing with Chaining
     */
    public int remainderHash(K key) {
        return (Integer) key % table_size;
    }


    /**
     * Used in while dealing with Collisions using Open Addressing
     * <p>
     * Probe Sequence is way to solve Collisions, it reduces the chances of collisions.
     * Probe Sequence has two types: linear, and quadratic
     *
     * <p>
     * Linear-Probe gets the key, hash it. if the hashed spot is not empty then it will find the empty spot.
     * if it iterate through whole list and still couldn't find the empty spot then the list is full
     * and item can not be added. This is called clustering when it has to iterate through the
     * list and it degrades the performance of function.
     * <p>
     * Quadratic-Probe works same but it uses another hashing function as followed
     * hashCode + a*i + b*i^2, where
     * hashCode = remainderHash(key)
     * a and b are constants and i is the index in the array
     * a = 0, b = 1
     * Now we need to increment them and explore the array until we find the empty spot
     * This also suffers from the problem called secondary clustering but it is still better then linear-probe
     * <p>
     * To solve the secondary clustering problem, the formula is followed:
     * h + i*h'(k)
     * where h is the initial hash code
     * i   is the starting at the index and we increment it by 1 until we find the empty spot
     * h'(k) is secondary hash function applied on the key
     * <p></p>
     * <b>Using a prime number as size of table would decrease the chances of collision</b>
     * <p></p>
     * <p> <b>There are 3 popular and widely used hashing functions</b></p>
     * <ul>
     *     <li><b>Remainder Hashing: key % table_size </b></li>
     *     <li><b>Multiplication Hashing:  table_size * (key * k % 1) where k is decimal in the range from 0 to 1</b></li>
     *
     *      <li><b>Universal Hashing</b>
     *      <p>Both remainder and multiplication functions are easy if anyone knows our table size and constant value
     *          then they can have access to our data, To address this problem, we have a hashing technique called universal hashing.
     *          <br/>
     *          It works by choosing a random function from a universal set of hash functions at the start of execution.
     *          This makes it difficult for an attacker to guess the exact working of hashing technique used. By using this method, the same sequence of keys
     *          will produce a different sequence of hashing values on every execution.
     *
     *      </p>
     *     </li>
     * </ul>
     */
    public int linearProbing(K key) {
        int code = remainderHash(key);


        /**
         search(key, array)
         s = len(array)
         hashCode = hash(key, s)
         i = 0
         while(i < s and array[(hashCode + i) % s] != null and array[(hashCode + i)%s].key != key){
         i++
         }
         keyValue = array[(hashCode + i) % s]

         if(keyValue != null and keyValue.key == key) return keyValue.value
         else return null
         **/
        return code;
    }

}
