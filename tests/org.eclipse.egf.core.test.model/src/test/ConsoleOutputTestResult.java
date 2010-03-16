/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Console Output Test Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.ConsoleOutputTestResult#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.TestPackage#getConsoleOutputTestResult()
 * @model
 * @generated
 */
public interface ConsoleOutputTestResult extends TestResult {
  /**
     * Returns the value of the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @return the value of the '<em>Text</em>' attribute.
     * @see #setText(String)
     * @see test.TestPackage#getConsoleOutputTestResult_Text()
     * @model required="true"
     * @generated
     */
  String getText();

  /**
     * Sets the value of the '{@link test.ConsoleOutputTestResult#getText <em>Text</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @param value the new value of the '<em>Text</em>' attribute.
     * @see #getText()
     * @generated
     */
  void setText(String value);

} // ConsoleOutputTestResult
