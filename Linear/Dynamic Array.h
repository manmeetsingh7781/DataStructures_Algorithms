#pragma once
#include <iostream>
using namespace std;

/*
	created by Manmeet Singh, Oct-25, 2019
	What are Arrays?
	* Array is a container which can hold a fix number of items and these items should be of the same type.
		Most of the data structures make use of arrays to implement their algorithms.
		Following are the important terms to understand the concept of Array.
	Difference b/w Array and Dynamic Arrays:
		The size of dynamic is vary depending on the length of elements, the size will automatically be modified depending on the operations of user.
	Element − Each item stored in an array is called an element.
	Index − Each location of an element in an array has a numerical index, which is used to identify the element
	Basic Operations:
		display − print all the array elements one by one.
		Insertion − Adds an element at the given index.
		remove − Deletes an element at the given index.
		contains − Searches an element using the by the given value.
		Update − Updates an element at the given index.
	Dynamic Array Operations:
		sort - sorts the elements [A-Z, 0 - 9]
		reverse - reverse the elements [Z-A, 9 - 0]
		getElement - returns element at given position
		size - returns the length of array
		indexOf - returns the index of given DataType
*/

template <class DataType>
class Array {

private:
    int SIZE = 5;
    int index;
    bool isFixed;
    DataType *elements;
    bool isFull() {
        return index == (SIZE - 1);
    }

public:
    Array();
    Array(int);
    DataType getElement(int);

    int getLength();
    int indexOf(DataType);

    bool contains(DataType);
    bool insert(DataType);
    bool insert(int, DataType);
    bool update(int, DataType);
    bool remove(int);

    void display();
    void sort();
    void reverse();
};


template <class DataType>
Array<DataType>::Array() {
    this->index = 0;
    this->elements = new DataType[this->SIZE];
    isFixed = false;
}


template <class DataType>
Array<DataType>::Array(int s):SIZE(s) {
    this->elements = new DataType[this->SIZE];
    for (int i = 0; i <= s; i++) {
        this->elements[i] = 0;
    }
    this->index = 0;
    isFixed = true;
}



template <class DataType>
int Array<DataType>::getLength() {
    return this->index;
}

template <class DataType>
bool Array<DataType>::insert(DataType item) {

    if (isFixed and isFull()) {
        cout << "List is Full, insertation failed: item '"<< item <<"'\n";
        return false;
    }

    if (isFull() and not isFixed) {
        SIZE++;
        DataType* copy_element = new DataType[SIZE + 1];
        int i;
        for (i = 0; i < SIZE; i++) {
            copy_element[i] = this->elements[i];
        }

        this->elements = NULL;
        delete this->elements;

        this->elements = new DataType[SIZE];
        for (i = 0; i < SIZE; i++) {
            this->elements[i] = copy_element[i];
        }
    }

    this->elements[index++] = item;
    return true;
}

template <class DataType>
bool Array<DataType>::insert(int position, DataType item) {
    if (position < 0 or position > SIZE) {
        cout << "Invalid Position\n";
        return false;
    }

    if (not isFixed) {
        if (isFull()) {
            SIZE++;
        }
    }
    else if (isFixed and isFull()) {
        cout << "List is Full, insertation failed: item '" << item << "' at given Position: '" << position <<"'\n";
        return false;
    }
    if(position == 0){
        insert(item);
    }else {
        int i;

        DataType *copy_element = new DataType[SIZE];

        for (i = 0; i < SIZE; i++) {

            if (i < position) {
                copy_element[i] = this->elements[i];

            }else if (i == position) {
                copy_element[i + 1] = this->elements[i];
                copy_element[position] = item;
            }
            else {
                copy_element[i+1] = this->elements[i];
            }

        }

        this->elements = NULL;
        delete this->elements;
        this->elements = new DataType[SIZE];
        for (i = 0; i < SIZE; i++) {
            this->elements[i] = copy_element[i];
        }
        ++index;
        return true;
    }

    return false;
}

template <class DataType>
bool Array<DataType>::contains(DataType item) {
    for (int i = 0; i <= index; i++) {
        if (this->elements[i] == item) return true;
    }
    return false;
}

template <class DataType>
bool Array<DataType>::update(int position, DataType item) {
    if (position < 0 or position > SIZE) {
        cout << "Invalid Position\n";
        return false;
    }
    else {
        this->elements[position] = item;
        return true;
    }
}

template <class DataType>
DataType Array<DataType>::getElement(int position) {
    if (position < 0 or position >SIZE) {
        cout << "Invalid Position\n";
        exit(-1);
    }
    else {
        return this->elements[position];
    }
}

template <class DataType>
int Array<DataType>::indexOf(DataType item) {
    if (this->contains(item)) {
        for (int i = 0; i <= index;  i++) {
            if (item == elements[i]) return i;
        }
    }
    return -1;
}


template <class DataType>
void Array<DataType>::display() {
    for (int i = 0; i <= index; i++)
        cout << this->getElement(i) << endl;

}


template <class DataType>
bool Array<DataType>::remove(int position) {
    if (position < 0 or position > SIZE) {
        cout << "Invalid Position\n";
        return false;
    }
    else {

        DataType* copy_elements = new DataType[SIZE];
        int i;
        for (i = 0; i <= index; i++) {
            if (i > position){
                copy_elements[i] = this->elements[i + 1];
            }
            else if (i == position){
                copy_elements[i] = this->elements[i + 1];
            }
            else{
                copy_elements[i] = this->elements[i];
            }
        }
        SIZE--;
        index--;
        this->elements = NULL;
        delete this->elements;
        this -> elements = new DataType[SIZE];
        for (i = 0; i <= index; i++)
            this->elements[i] = copy_elements[i];
        return true;
    }
}


template <class DataType>
void Array<DataType>::reverse() {
    DataType* copy_elements = this->elements;
    this->elements = NULL;
    delete this -> elements;
    this->elements = new DataType[SIZE];
    for (int i = index, j = 0; j <= index; i--, j++) {
        this->elements[j] = copy_elements[i];
    }
}

template <class DataType>
void Array<DataType>::sort(){
    DataType  temp;
    for(int i = 0; i < SIZE-1; i++){
        for(int j = 0; j < SIZE-i-1; j++){
            if (this->elements[j] > this->elements[j+1]){
                temp = this->elements[j];
                this->elements[j] = this->elements[j+1];
                this->elements[j+1] = temp;
            }
        }
    }
}
